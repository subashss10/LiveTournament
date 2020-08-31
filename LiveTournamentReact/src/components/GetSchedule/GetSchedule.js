import React from 'react';
import axios from 'axios';
import { Container, Jumbotron, Row,Col} from 'react-bootstrap';
import { Link } from '@version/react-router-v3';
import { NavDropdown } from 'react-bootstrap';
import '@fortawesome/fontawesome-free/css/all.min.css'; 
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbreact/dist/css/mdb.css';
import { MdDelete } from "react-icons/md";

class GetSchedule extends React.Component {
    constructor(props) {
        super(props);
        this.getSchedules = this.getSchedules.bind(this);
        this.getMatchType = this.getMatchType.bind(this);
        this.state = {
            schedules: []
        };
    }

    getMatchType(type){
        switch(type){
            case 1:
                return 'International';
            case 2:
                return 'T20';
            case 3:
                return 'Test';
            default:
                return 'International';            
        }
    }
    

    getSchedules()
    {
        axios.get('http://localhost:8080/Live-Tournament/schedule').then(resp => {
            console.log(resp.data);
            this.setState({ schedules: resp.data });
        });
    }

    componentDidMount() {
        this.getSchedules();
        
        
    }

    deleteSchedule(Id) 
    {
        const configs ={
            CONFIG:{
                headers:{
                    'Content-Type':'application/json'
                }
            }
        }
        axios.delete('http://localhost:8080/Live-Tournament/schedule/' + Id,configs.CONFIG ).then(resp => {
            // console.log(resp.data);
            // this.setState({isDeleted:true });
             this.getSchedules();
        })
        .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <>
            <Row><Col xs={3}><Container><Jumbotron>
                            Date


                                </Jumbotron></Container></Col>
                                <Col xs={6}><Container><Jumbotron>
                            Match Details


                                </Jumbotron></Container></Col>
                                <Col xs={3}><Container><Jumbotron>
                                Time
    
    
                                    </Jumbotron></Container></Col>
                                </Row>
                    {
                        this.state.schedules.map((schedule)=>{
                        return <Row><Col xs={3}><Container><Jumbotron>
                            {schedule.Date}


                                </Jumbotron></Container></Col>
                                <Col xs={6}><Container><Jumbotron>
                            {schedule.Team1 + ' Vs ' + schedule.Team2 + ' at ' + schedule.Venue + ' ( ' + this.getMatchType(schedule.MatchTypeId) + ' )'}


                                </Jumbotron></Container></Col>
                                <Col xs={3}><Container><Jumbotron>
                                {schedule.Time}
    
    
                                    </Jumbotron></Container></Col>
                                </Row>;})
                    }
                    {/* <NavDropdown.Item eventKey="4.1"><Link to={{pathname:'NewTeam'}}>Create New Schedule</Link></NavDropdown.Item> */}
               
            </>
        );
    }
}


export default GetSchedule;















