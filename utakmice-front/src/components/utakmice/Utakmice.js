import React, { useCallback, useEffect, useState } from 'react'
import { Button, Col, Collapse, Form, Row, Table } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import Axios from '../../apis/Axios';
import {IsLoggedIn} from '../../service/auth'
import '../../index.css'
import { Rola } from '../../service/auth'

const Utakmice = (props) => {

    var navigate = useNavigate()
    const [utakmice, setUtakmice] = useState([])
    const [reprezentacije, setReprezentacije] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPage, setTotalPage] = useState(0)
    const [isChecked, setIsChecked] = useState(false);
    const [searchParams, setSearchParams] = useState({
      reprezentacijaAId: "",
      reprezentacijaBId: ""
    })

    const getAll = useCallback((nextPage) => {
        const config = {
          params: {
            reprezentacijaAId: searchParams.reprezentacijaAId,
            reprezentacijaBId: searchParams.reprezentacijaBId,
            pageNo: nextPage
          }
        }
        Axios.get('/utakmice', config)
        .then(res => {
          console.log(res)
          setUtakmice(res.data)
          setPageNo(nextPage)
          setTotalPage(res.headers["total-pages"])
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    const getAll2 = useCallback(() => {
      Axios.get('/reprezentacije')
      .then(res => {
        console.log(res)
        setReprezentacije(res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }, [])
  
    useEffect(() => {
      getAll(pageNo)
      getAll2()
    }, [])

    const najboljiStrelac = useCallback(() => {
      Axios.get('/igraci/najboljiStrelac')
      .then(res => {
        console.log(res)
        alert("Najbolji strelac je " + res.data.ime + " " + res.data.prezime + " sa " + res.data.postignutiGolovi + " postignutih golova!")
      })
      .catch(err => {
        console.log(err)
      })
    }, [])
  
    useEffect(() => {
      getAll(pageNo)
      getAll2()
    }, [])

    const goToAdd = () => {
      navigate('/utakmica/add')
    }

    const delte = (utakmicaId) => {
      const confirmDelete = window.confirm("Da li ste sigurni da zelite da obrisete ovu utakmicu?");
      if (confirmDelete) {
        Axios.delete('/utakmice/' + utakmicaId)
        .then(res => {
          console.log(res)
          setUtakmice((utakmice)=>utakmice.filter(utakmica => utakmica.id !== utakmicaId))
        })
        .catch(err => {
          console.log(err)
        })
      } else {
        navigate('/utakmice')
      }
    }

    const GoA = (utaId, repA) => {
      
      Axios.put('/utakmice/' + utaId + '/noviGoA')
      .then(res => {
          console.log(res)
          navigate('/igraci/' + repA)
        })
        .catch(err => {
          console.log(err)
        })
  }

  const GoB = (utaId, repB) => {
  
    Axios.put('/utakmice/' + utaId + '/noviGoB')
    .then(res => {
        console.log(res)
        navigate('/igraci/' + repB)
      })
      .catch(err => {
        console.log(err)
      })
}

    const rednerAll = () => {
      return utakmice.map((utakmica) => {
        return(
          <tr key={utakmica.id}>
            <td>{utakmica.nazivReprezentacijaA}</td>
            <td>{utakmica.nazivReprezentacijaB}</td>
            <td>{utakmica.goloviA}</td>
            <td>{utakmica.goloviB}</td>
            {IsLoggedIn() && Rola() == "admin" &&<td><Button className="btn btn-info" onClick={() => GoA(utakmica.id, utakmica.reprezentacijaAId)}>A+1</Button></td>}
            {IsLoggedIn() && Rola() == "admin" &&<td><Button className="btn btn-info" onClick={() => GoB(utakmica.id, utakmica.reprezentacijaBId)}>B+1</Button></td>}
            {IsLoggedIn() && Rola() == "admin" && <td><Button className="btn btn-danger" onClick={() => delte(utakmica.id)}>Ukloni</Button></td>}
          </tr>
        )
      })

    }

    const rednerAll2 = () => {
      return reprezentacije.map((reprezentacija) => {
        return(<option key={reprezentacija.id} value={reprezentacija.id}>{reprezentacija.skraceniNaziv}</option>)
      })

    }

    const serchValue = (event) => {
      let name = event.target.name
      let value = event.target.value
      
      searchParams[name] = value
      setSearchParams(searchParams)
      getAll(0)
    }
    
    return (
      <div>
        <Row className="justify-content-center">
        <Col>
          <br/><br/>
          <Row><h1>Utakmice</h1></Row>
            <Form.Group style={{marginTop:35}}>
                <Form.Check type="checkbox" label="Show search form" onClick={(event) => setIsChecked(event.target.checked)}/>
            </Form.Group>
            <Collapse in={isChecked}>
            <Form style={{marginTop:10}}>
                    <Form.Group>
                    <Form.Label>Reprezentacija A</Form.Label>
                    <Form.Select name='reprezentacijaAId' onChange={serchValue}>
                        <option value={""}>--izaberi reprezentacija--</option>
                        {rednerAll2()}
                    </Form.Select>
                    </Form.Group>
                    <Form.Group>
                    <Form.Label>Reprezentacija B</Form.Label>
                    <Form.Select name='reprezentacijaBId' onChange={serchValue}>
                        <option value={""}>--izaberi reprezentacija--</option>
                        {rednerAll2()}
                    </Form.Select>
                    </Form.Group>     
            </Form>
            </Collapse>
          <Row>
            <Col>
              <Table>
                <thead>
                  <tr>
                    <th>Reprezentacija A</th>
                    <th>Reprezentacija B</th>
                    <th>Golovi A</th>
                    <th>Golovi B</th>
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  {rednerAll()}
                </tbody>
              </Table>
            </Col>
          </Row>
          {IsLoggedIn() && Rola() == "admin" && <Button className="btn btn-success" onClick={() => goToAdd()}>Kreiraj novu utakmicu</Button>}
          {IsLoggedIn() && <Button style={{float: 'right'}} className="btn btn-info" onClick={() => najboljiStrelac()}>Najbolji strelac</Button>}
          <br/>
          <div style={{ display: 'flex', justifyContent: 'center' }}>
            <Button className="btn btn-light btn-sm" disabled={pageNo==0} onClick={() => getAll(pageNo-1)}>{'❮'}</Button>
            <span style={{ margin: '10px' }}> {pageNo + 1} </span> 
           <Button className="btn btn-light btn-sm" disabled={pageNo==totalPage-1 || utakmice.length === 0} onClick={() => getAll(pageNo+1)}>{'❯'}</Button>
          </div>
        </Col>
        </Row>
      </div>
    );
  }

export default Utakmice;