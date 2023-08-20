import { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Axios from "../../apis/Axios";

const NovaUtakmica = () => {

    const utakmica = {
        id: -1,
        reprezentacijaAId: '',
        reprezentacijaBId: ''

    }
    const [reprezentacije, setReprezentacije] = useState([])
    const [novaUtakmice, setNovaUtakmica] = useState(utakmica)
    var navigate = useNavigate()


    const dodaj = () => {

        const dto = {
            reprezentacijaAId: novaUtakmice.reprezentacijaAId,
            reprezentacijaBId: novaUtakmice.reprezentacijaBId
        }

        Axios.post('/utakmice', dto)
            .then(res => {
                console.log(res)
                navigate('/utakmice')
            })
            .catch(err => {
                console.log(err)
                alert("Doslo je do greske, pokusajte novi unos!")
            })
    }

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
        getAll2()
      }, [])

    const valueInputChanged = (e) => {

        let input = e.target;
        let name = input.name;
        let value = input.value;

        novaUtakmice[name] = value;
        setNovaUtakmica(novaUtakmice);
    }

    const rednerAll2 = () => {
        return reprezentacije.map((reprezentacija) => {
        return(<option key={reprezentacija.id} value={reprezentacija.id}>{reprezentacija.skraceniNaziv}</option>)
        })

    }

    return(
        <div>
            <Col>
          <br/><br/>
          <Row><h1>Kreiraj utakmicu</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
              <Form>
                <Form.Label htmlFor="reprezentacijaAId">Reprezentacija B</Form.Label>
                <Form.Select name='reprezentacijaAId' onChange={(e) => valueInputChanged(e)}>
                    <option value={""}>--izaberi reprezentacija--</option>
                    {rednerAll2()}
                </Form.Select>
                <Form.Label htmlFor="reprezentacijaBId">Reprezentacija A</Form.Label>
                <Form.Select name='reprezentacijaBId' onChange={(e) => valueInputChanged(e)}>
                    <option value={""}>--izaberi reprezentacija--</option>
                    {rednerAll2()}
                </Form.Select>
                <br/>
                <Button className="btn btn-success" onClick={() => dodaj()}>Kreiraj utakmica</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>
    );


}

export default NovaUtakmica;