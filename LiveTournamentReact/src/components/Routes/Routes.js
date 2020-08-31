import React from 'react';
import { Router, Route, browserHistory } from '@version/react-router-v3';
import App from '../../App';
import MyTeam from '../MyTeam/MyTeam';
import NewTeam from '../NewTeam/NewTeam';
import NewPlayer from '../NewPlayer/NewPlayer';
import GetSchedule from '../GetSchedule/GetSchedule';
import UpdateSchedule from '../UpdateSchedule/UpdateSchedule';


class Routes extends React.Component {

    render() {
        return (
            <Router history = {browserHistory}>
                <Route path="/" component={App}/>
                <Route path="MyTeam" component={MyTeam} />
                <Route path="NewTeam" component={NewTeam} />
                <Route path="NewPlayer" component={NewPlayer} />
                <Route path="/GetSchedule" component={GetSchedule} />
                <Route path="UpdateSchedule" component={UpdateSchedule} />
            
            </Router>
        );
    }
}


export default Routes;















