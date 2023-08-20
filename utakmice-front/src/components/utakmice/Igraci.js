import { Button, Col, Form, Row } from "react-bootstrap";
import Axios from "../../apis/Axios";
import { useCallback, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const Igraci = () => {

    var navigate = useNavigate()
    var params = useParams()
    var reprezentacijaId = params.id;

    const [igraci, setIgraci] = useState([])
    const [igracId, setIgracId] = useState()
      
    const getAll = useCallback((reprezentacijaId) => {
        const config = {
            params: {
                reprezentacijaId: reprezentacijaId
            }
          }
        Axios.get('/igraci/reprezentacije', config)
        .then(res => {
          console.log(res)
          setIgraci(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    useEffect(() => {
        getAll(reprezentacijaId)
    }, [])
    
    const edit = (igracId) => {

        Axios.put('/igraci/' + igracId + '/noviGoIgraca')
        .then(res => {
            console.log(res)
            navigate('/utakmice')
          })
          .catch(err => {
            console.log(err)
          })
    }

    const rednerAll2 = () => {
        return igraci.map((igrac) => {
          return(<option key={igrac.id} value={igrac.id}>{igrac.ime} {igrac.prezime}</option>)
        })
  
    }

    return (
        <div>
             <Col>
          <br/><br/><br/><br/>
          <Row><h1>Strelac gola</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
              <Form>
              <Form.Group>
                    <Form.Label>Igraci igraci</Form.Label>
                    <Form.Select name='igracId' onChange={(e) => setIgracId(e.target.value)}>
                        <option value={""}>--izaberi igraca--</option>
                        {rednerAll2()}
                    </Form.Select>
                    </Form.Group>     
                <br/>
                <Button className="btn btn-primary" onClick={() => edit(igracId)}>Novi go strelca</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>
    );
    
}

export default Igraci;