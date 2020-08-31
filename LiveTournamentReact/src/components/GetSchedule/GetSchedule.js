import React from 'react';
import axios from 'axios';
import { Container, Jumbotron} from 'react-bootstrap';
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
        this.state = {
            schedules: []
        };
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
                    {
                        this.state.schedules.map((schedule)=>{
                        return  <Container><Jumbotron>
                            {schedule.Date}


                                </Jumbotron></Container>;})
                    }
                    {/* <NavDropdown.Item eventKey="4.1"><Link to={{pathname:'NewTeam'}}>Create New Schedule</Link></NavDropdown.Item> */}
               
            </>
        );
    }
}


export default GetSchedule;















