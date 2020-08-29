import React from 'react';
import axios from 'axios';
import { Link } from '@version/react-router-v3';
import { Form,FormControl, Button, Jumbotron,Container,Image,Row,Col} from 'react-bootstrap';
import './MyTeam.scss';
import GetPlayers from '../GetPlayers/GetPlayers';
import NewPlayer from '../NewPlayer/NewPlayer';

class MyTeam extends React.Component {
    constructor(props) {
        super(props);
        this.updateTeamDescription = this.updateTeamDescription.bind(this);
        this.updateTeamName = this.updateTeamName.bind(this);
        this.updateTeam = this.updateTeam.bind(this);
        this.state = {
            team: {},
            teamId : ""
        };
        // console.log('test');
    }

 

    componentDidMount() {

        this.setState({ team: this.props.location.state.team });
        // console.log('didmount');

    }

    updateTeamDescription(e) {
        // console.log(e.target.value);
        let temp = { ...this.state.team, TeamDescription: e.target.value };
        // console.log(temp);
        this.setState({ team: temp });
    }

    updateTeamName(e) {
        // console.log(e.target.value);
        let temp = { ...this.state.team, TeamName: e.target.value };
        // console.log(temp);
        this.setState({ team: temp });
    }

    updateTeam() {

        const configs ={
            CONFIG:{
                headers:{
                    'Content-Type':'application/json',
                    'Authorization':localStorage.getItem('token')
                }
            }

        }

        axios.put('http://localhost:8080/Live-Tournament/team/' + this.state.team.Id, this.state.team,configs.CONFIG)
            .then(resp => {
                console.log(resp.data);
                this.setState({ team: resp.data });
                this.props.location.state.getTeams();
            })
            .catch(err => {
                console.log(err);
            });

           
        // axios.put('http://localhost:8080/Live-Tournament/team/2', { 
        //     "TeamName": "Scotland",
        //     "TeamDescription": "Scotland Team",
        //     "CreatedBy": 2
        // },configs.CONFIG)
        //     .then(resp => {
        //         console.log(resp.data);
        //         this.setState({ team: resp.data });
        //     })
        //     .catch(err => {
        //         console.log(err);
        //     });
    }

    render() {
        return (
            <>
                {/* <div>MyTeam is {this.state.team.Id}</div>
                <div>{this.state.team.TeamName}</div> */}
                <Container>
                    <Jumbotron> 
                        <Container>
                            <Row>
                                <Col xs={11}>
                                    <Form.Label column sm="2" className='label'>Team Name</Form.Label>
                                    <FormControl className="teaminput"
                                        onChange={(e) => this.updateTeamName(e)}
                                        value={this.state.team.TeamName}
                                        placeholder="Team Name"
                                        aria-label="Team Name"
                                        aria-describedby="basic-addon1"
                                    />
                                    <Form.Label column sm="2" className='label'>Team Description</Form.Label>
                                    <FormControl className="teaminput"
                                        onChange={(e) => this.updateTeamDescription(e)}
                                        value={this.state.team.TeamDescription}
                                        placeholder="Team Description"
                                        aria-label="Team Description"
                                        aria-describedby="basic-addon1"
                                    />
                                    <Button variant="success" onClick={() => this.updateTeam()} >Update</Button>{' '}
                                    <Button variant="success"><Link to='/' className="link">Back</Link></Button>{' '}
                                    {/* <h1>{this.state.team.Id}</h1> */}
                                </Col>
                                <Col xs={1}>
                                    <Image src="D:/Projects/ReactJs/my-app/src/images/countries/india.png" rounded />
                                </Col>
                            </Row>
                        </Container>
                        
                    </Jumbotron>
                    <Jumbotron>
                        <NewPlayer teamName={this.state.team.TeamName}><Link to={{pathname:'NewPlayer'}}>Create New Player</Link></NewPlayer>
                    </Jumbotron>
                </Container>
               
                
                <GetPlayers teamId = {this.state.team.Id} teamName = {this.state.team.TeamName}/>

            </>
        );
    }
}


export default MyTeam;















