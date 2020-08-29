import React from 'react';
import axios from 'axios';
import { Link } from '@version/react-router-v3';
import { FormControl, Button, Jumbotron, Form, Container } from 'react-bootstrap';
import '../MyTeam/MyTeam.scss';

class Schedule extends React.Component {
    constructor(props) {
        super(props);
        this.InsertDate = this.InsertDate.bind(this);
        this.InsertMatchTypeId = this.InsertMatchTypeId.bind(this);
        this.InsertTeam1 = this.InsertTeam1.bind(this);
        this.InsertTeam2 = this.InsertTeam2.bind(this);
        this.InsertVenue = this.InsertVenue.bind(this);
        this.InsertSchedule = this.InsertSchedule.bind(this);


        this.state = {
            schedule : {Date : '',MatchTypeId : '',Team1 : '',Team2:'', Time : '',Venue : '', CreatedBy:2}
        };
        // console.log('test');
    }

 
    InsertDate(e) {
        console.log(e.target.value);
        let temp = { ...this.state.schedule, Date: e.target.value };
        console.log(temp);
        this.setState({ schedule: temp });
    }

    InsertMatchType(e) {
        console.log(e.target.value);
        let temp = { ...this.state.schedule, MatchType: e.target.value };
        console.log(temp);
        this.setState({ schedule: temp });
    }


    

    InsertTeam1(e) {
        console.log(e.target.value);
        let temp = { ...this.state.schedule, Team1 : e.target.value };
        console.log(temp);
        this.setState({ schedule: temp });
    }

    InsertTeam2(e) {
        console.log(e.target.value);
        let temp = { ...this.state.schedule, Team2: e.target.value };
        console.log(temp);
        this.setState({ schedule: temp });
    }



    InsertVenue(e) {
        console.log(e.target.value);
        let temp = { ...this.state.schedule, Venue: e.target.value };
        console.log(temp);
        this.setState({ schedule: temp });
    }

    InsertSchedule() {

        const configs ={
            CONFIG:{
                headers:{
                    'Content-Type':'application/json'
                }
            }
        }

        axios.post('http://localhost:8080/Live-Tournament/schedule', this.state.schedule,configs.CONFIG)
            .then(resp => {
                console.log(resp.data);
                this.setState({ player: resp.data });
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <>
                <Container>
                <Jumbotron>
                <Form.Label>Enter the Date of Match</Form.Label>
                <FormControl className="scheduleinput"
                    onChange={(e) => this.InsertDate(e)}
                    value={this.state.schedule.Date}
                    placeholder="YYYY-MM-DD"
                    aria-label="Date"
                    aria-describedby="basic-addon1"
                />
                <Form.Label>Enter Match Type</Form.Label>
                <FormControl className="scheduleinput"
                    onChange={(e) => this.InsertMatchType(e)}
                    value={this.state.player.TeamName}
                    placeholder="Team Name"
                    aria-label="Team Name"
                    aria-describedby="basic-addon1"
                />
                <Form.Label>Enter DOB</Form.Label>
                <FormControl className="playerinput"
                    onChange={(e) => this.InsertDOB(e)}
                    value={this.state.player.DOB}
                    placeholder="yyyy-mm-dd"
                    aria-label="DOB"
                    aria-describedby="basic-addon1"
                />
                <Form.Label>Enter Batting Style</Form.Label>
                <FormControl className="playerinput"
                    onChange={(e) => this.InsertBattingStyle(e)}
                    value={this.state.player.BattingStyle}
                    placeholder="Batting Style"
                    aria-label="Batting Style"
                    aria-describedby="basic-addon1"
                />
                 <Form.Label>Enter Bowling Style</Form.Label>
                 <FormControl className="playerinput"
                    onChange={(e) => this.InsertBowlingStyle(e)}
                    value={this.state.player.BowlingStyle}
                    placeholder="Bowling Style"
                    aria-label="Bowling Style"
                    aria-describedby="basic-addon1"
                />
                <Button variant="success" onClick={() => this.InsertPlayer()} >Insert</Button>{' '}
                <Button variant="success"><Link to='/'>Back</Link></Button>{' '}
                </Jumbotron>
                </Container>

            </>
        );
    }
}


export default Schedule;















