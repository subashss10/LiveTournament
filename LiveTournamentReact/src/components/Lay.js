
import React from 'react';
import { Jumbotron,Container,Row, Col } from 'react-bootstrap';

class Lay extends React.Component {

    render() {
        return (
            <div className = "Lay">
                <Jumbotron>
                <Container>
                    <Row>
                        <Col>Latest News</Col>
                        <Col xs={6}>Plans in Place</Col>
                        <Col>Advertisement</Col>
                    </Row>
                    <Row>
                        <Col>Trending</Col>
                        <Col xs={5}>Latest Photos</Col>
                        <Col>Specials</Col>
                    </Row>
                </Container>

                </Jumbotron>
            </div>
        );
    }

}

export default Lay;