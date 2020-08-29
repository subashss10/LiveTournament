import React from 'react';
import { Jumbotron } from 'react-bootstrap';

class MatchesJumbo extends React.Component {

    render() {
        return (
            <div className = "MatchesJumbo">
                <Jumbotron>
                    <h1>Featured Matches</h1>

                </Jumbotron>
            </div>
        );
    }

}

export default MatchesJumbo;