import React from 'react';
import axios from 'axios';
import { Link } from '@version/react-router-v3';
import { NavDropdown } from 'react-bootstrap';
import '@fortawesome/fontawesome-free/css/all.min.css'; 
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbreact/dist/css/mdb.css';
import { MdDelete } from "react-icons/md";

class Teams extends React.Component {
    constructor(props) {
        super(props);
        this.getTeams = this.getTeams.bind(this);
        this.state = {
            teams: []
        };
    }
    

    getTeams()
    {
        axios.get('http://localhost:8080/Live-Tournament/team').then(resp => {
            console.log(resp.data);
            this.setState({ teams: resp.data });
        });
    }

    componentDidMount() {
        this.getTeams();
        
        
    }

    deleteTeam(Id) 
    {
        const configs ={
            CONFIG:{
                headers:{
                    'Content-Type':'application/json'
                }
            }
        }
        axios.delete('http://localhost:8080/Live-Tournament/team/' + Id,configs.CONFIG ).then(resp => {
            // console.log(resp.data);
            // this.setState({isDeleted:true });
             this.getTeams();
        })
        .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <>
                <NavDropdown title="Teams" id="nav-dropdown">
                    {
                        this.state.teams.map((team)=>{
                        return <NavDropdown.Item eventKey="4.1"><Link to={{pathname:'MyTeam',state:{team:team,getTeams:this.getTeams}}}>{team.TeamName}</Link>  <MdDelete onClick={() => this.deleteTeam(team.Id)}/></NavDropdown.Item>;})
                    }
                    <NavDropdown.Item eventKey="4.1"><Link to={{pathname:'NewTeam'}}>Create New Team</Link></NavDropdown.Item>
                </NavDropdown>
            </>
        );
    }
}


export default Teams;















