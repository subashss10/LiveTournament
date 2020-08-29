import React from 'react';
import axios from 'axios';
import { Link } from '@version/react-router-v3';
import { FormControl, Button, Jumbotron, Form } from 'react-bootstrap';
import '../MyTeam/MyTeam.scss';

class NewTeam extends React.Component {
    constructor(props) {
        super(props);
        this.InsertTeamDescription = this.InsertTeamDescription.bind(this);
        this.InsertTeamName = this.InsertTeamName.bind(this);
        this.InsertTeam = this.InsertTeam.bind(this);
        this.state = {
            team: {TeamName:'',TeamDescription:'',CreatedBy:2}
        };
        // console.log('test');
    }

 

    

    InsertTeamDescription(e) {
        console.log(e.target.value);
        let temp = { ...this.state.team, TeamDescription: e.target.value };
        console.log(temp);
        this.setState({ team: temp });
    }

    InsertTeamName(e) {
        console.log(e.target.value);
        let temp = { ...this.state.team, TeamName: e.target.value };
        console.log(temp);
        this.setState({ team: temp });
    }

    InsertTeam() {

        const configs ={
            CONFIG:{
                headers:{
                    'Content-Type':'application/json'
                }
            }
        }

        axios.post('http://localhost:8080/Live-Tournament/team', this.state.team,configs.CONFIG)
            .then(resp => {
                console.log(resp.data);
                this.setState({ team: resp.data });
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <>
                <Jumbotron>
                <Form.Label>Enter Team Name</Form.Label>
                <FormControl className="teaminput"
                    onChange={(e) => this.InsertTeamName(e)}
                    value={this.state.team.TeamName}
                    placeholder="Team Name"
                    aria-label="Team Name"
                    aria-describedby="basic-addon1"
                />
                <Form.Label>Enter Team Description</Form.Label>
                <FormControl className="teaminput"
                    onChange={(e) => this.InsertTeamDescription(e)}
                    value={this.state.team.TeamDescription}
                    placeholder="Team Description"
                    aria-label="Team Description"
                    aria-describedby="basic-addon1"
                />
                <Button variant="success" onClick={() => this.InsertTeam()} >Insert</Button>{' '}
                <Button variant="success"><Link to='/'>Back</Link></Button>{' '}
                </Jumbotron>

            </>
        );
    }
}


export default NewTeam;















