import React from 'react';
import { Container, Row,Col, Jumbotron ,Image} from 'react-bootstrap';
import axios from 'axios';
import Player from '../Player/Player';
import { MdThumbsUpDown } from 'react-icons/md';
// import { Link } from '@version/react-router-v3';
// import { Form,FormControl, Button, Jumbotron,Container} from 'react-bootstrap';
// import MyTeam from '../MyTeam/MyTeam';



class GetPlayers extends React.Component {
    constructor(props) {
        super(props);
        this.getPlayerType=this.getPlayerType.bind(this);
        this.state = {
            players:[],
            batsmen:[],
            bowlers:[],
            allrounders:[],
            keepers:[]
        }
    }
    getPlayers()
    {
        axios.get('http://localhost:8080/Live-Tournament/player').then(resp => {
            console.log(resp.data);
            this.setState({ players: resp.data });
        });

    }
    componentDidMount() {
        this.getPlayers();
        
        
    }

    getPlayerType(player){
        console.log(player);
        switch(player.PlayerRoleId){
            case 1:
                return <Container><Row><Col><Jumbotron>{player.PlayerName}</Jumbotron></Col></Row></Container>
            case 2:
                return <Container><Row><Col><Jumbotron>{player.PlayerName}</Jumbotron></Col></Row></Container>
            case 3:
                return <Container><Row><Col><Jumbotron>{player.PlayerName}</Jumbotron></Col></Row></Container>
            default:
                return <Container><Row><Col><Jumbotron>{player.PlayerName}</Jumbotron></Col></Row></Container>
        }
    }

    
    // <div>{this.props.teamId}</div>
                    // <div>{this.props.teamName}</div>
    
    render() {
        console.log(this.state.players);
        const teamId = this.props.teamId;
        const batsmen =  this.state.players.filter(player=>player.TeamId === this.props.teamId && player.PlayerRoleId === 1).map((player)=>{
            return <Player player = {player}></Player>
            });   
        const bowlers =  this.state.players.filter(player=>player.TeamId === this.props.teamId && player.PlayerRoleId === 2).map((player)=>{
            return <Player player = {player}></Player>
            }); 
        const allrounders =  this.state.players.filter(player=>player.TeamId === this.props.teamId && player.PlayerRoleId === 3).map((player)=>{
            return <Player player = {player}></Player>
            }); 
        const keepers =  this.state.players.filter(player=>player.TeamId === this.props.teamId && player.PlayerRoleId === 4).map((player)=>{
            return <Player player = {player}></Player>
            });      


        return (
            <>
                <Container>
                    <Row>
                        <Col xs={12}><h1>BATSMAN</h1></Col>
                    </Row>
                    <Row>
                        {batsmen}
                    </Row>
                </Container>
                <Container>
                    <Row>
                        <Col xs={12}><h1>KEEPERS</h1></Col>
                    </Row>
                    <Row>
                        {keepers}
                    </Row>
                </Container>
                <Container>
                    <Row>
                        <Col xs={12}><h1>ALLROUNDERS</h1></Col>
                    </Row>
                    <Row>
                        {allrounders}
                    </Row>
                </Container>
                <Container>
                    <Row>
                        <Col xs={12}><h1>BOWLERS</h1></Col>
                    </Row>
                    <Row>
                        {bowlers}
                    </Row>
                </Container>
            </>
        );
    }
        
    
}
    
export default GetPlayers;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    