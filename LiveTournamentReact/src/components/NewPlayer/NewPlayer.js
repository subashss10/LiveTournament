import React from 'react';
import axios from 'axios';
import { Link } from '@version/react-router-v3';
import { FormControl, Button, Jumbotron, Form, Container } from 'react-bootstrap';
import '../MyTeam/MyTeam.scss';

class NewPlayer extends React.Component {
    constructor(props) {
        super(props);
        this.InsertPlayerName = this.InsertPlayerName.bind(this);
        this.InsertTeamName = this.InsertTeamName.bind(this);
        this.InsertDOB = this.InsertDOB.bind(this);
        this.InsertBattingStyle = this.InsertBattingStyle.bind(this);
        this.InsertBowlingStyle = this.InsertBowlingStyle.bind(this);


        this.state = {
            player : {PlayerName : '',TeamNmae : this.props.teamName,DOB : '',BattingStyle:'', BowlingStyle : '',CreatedBy:2}
        };
        // console.log('test');
    }

 
    InsertBattingStyle(e) {
        console.log(e.target.value);
        let temp = { ...this.state.player, BattingStyle: e.target.value };
        console.log(temp);
        this.setState({ player: temp });
    }

    InsertBowlingStyle(e) {
        console.log(e.target.value);
        let temp = { ...this.state.player, BowlingStyle: e.target.value };
        console.log(temp);
        this.setState({ player: temp });
    }


    

    InsertPlayerName(e) {
        console.log(e.target.value);
        let temp = { ...this.state.player, PlayerName: e.target.value };
        console.log(temp);
        this.setState({ player: temp });
    }

    InsertDOB(e) {
        console.log(e.target.value);
        let temp = { ...this.state.player, DOB: e.target.value };
        console.log(temp);
        this.setState({ player: temp });
    }



    InsertTeamName(e) {
        console.log(e.target.value);
        let temp = { ...this.state.player, TeamName: e.target.value };
        console.log(temp);
        this.setState({ player: temp });
    }

    InsertPlayer() {

        const configs ={
            CONFIG:{
                headers:{
                    'Content-Type':'application/json'
                }
            }
        }

        axios.post('http://localhost:8080/Live-Tournament/player', this.state.player,configs.CONFIG)
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
                <Form.Label>Enter Player Name</Form.Label>
                <FormControl className="playerinput"
                    onChange={(e) => this.InsertPlayerName(e)}
                    value={this.state.player.PlayerName}
                    placeholder="Player Name"
                    aria-label="Player Name"
                    aria-describedby="basic-addon1"
                />
                {/* <Form.Label>Team Name</Form.Label><br/>
                <Form.Label>{this.props.teamName}</Form.Label><br/> */}
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
                <Button variant="success"><Link to='/' className="link">Back</Link></Button>{' '}
                </Jumbotron>
                </Container>

            </>
        );
    }
}


export default NewPlayer;















