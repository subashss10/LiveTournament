import React from 'react';
import { Container, Row,Col, Jumbotron,Form ,Image} from 'react-bootstrap';
import '../MyTeam/MyTeam.scss';
import axios from 'axios';
import { MdThumbsUpDown } from 'react-icons/md';
// import { Link } from '@version/react-router-v3';
// import { Form,FormControl, Button, Jumbotron,Container} from 'react-bootstrap';
// import MyTeam from '../MyTeam/MyTeam';



class Player extends React.Component {
    constructor(props) {
        super(props);
        this.calculateAge = this.calculateAge.bind(this);
    }

    calculateAge(birthday) { // birthday is a date
        var birthdate = new Date(birthday);
        var ageDifMs = Date.now() - birthdate.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }
    
    render() {
             


        return (
            
            <Col xs={6}><Jumbotron><Container>
                <Row>
                    <Col xs lg="">
                    <Image className="playerimg" src={'./images/players/' + this.props.player.LogoPath} rounded />
                    
                    </Col>
                </Row>
                <br></br>
                <Row>
                    <Col xs="4"><Form.Label>Name</Form.Label></Col>
                    <Col xs="8"><Form.Label >{this.props.player.PlayerName}</Form.Label></Col>
                </Row>
                <Row>
                    <Col xs="4"><Form.Label>Age</Form.Label></Col>
                    <Col xs="8"><Form.Label >{this.calculateAge(this.props.player.DOB)}</Form.Label></Col>
                </Row>
                <Row>
                    <Col xs="4"><Form.Label >Batting Style</Form.Label></Col>
                    <Col xs="8"><Form.Label >{this.props.player.BattingStyle===undefined?"-":this.props.player.BattingStyle}</Form.Label></Col>
                </Row>
                <Row>
                    <Col xs="4"><Form.Label >Bowling Style</Form.Label></Col>
                    <Col xs="8"><Form.Label >{this.props.player.BowlingStyle===undefined?"-":this.props.player.BowlingStyle}</Form.Label></Col>
                </Row>
               
                </Container></Jumbotron></Col>
        );
    }
        
    
}
    
export default Player;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    