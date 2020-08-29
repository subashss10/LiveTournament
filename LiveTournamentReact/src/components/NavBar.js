import React from 'react';
import {Navbar,Nav,Form,FormControl,Button,Jumbotron,NavDropdown} from 'react-bootstrap';
import { GoogleLogin,GoogleLogout } from 'react-google-login';
import Teams from './Teams/Teams';

class NavBar extends React.Component
{

    

        render() {
            const responseGoogle = (response) => {
                console.log(response);
                localStorage.setItem('token',response.tokenId);
              }
            const logout = (response) => {
            console.log(response);
            }
        return (
            <div className="NavBar">
                <Jumbotron>
                    <Navbar bg="dark" variant="dark">
                        <Navbar.Brand href="#home">LiveTournament</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link href="#home">Live Scores</Nav.Link>
                            <Nav.Link href="#features">Schedule</Nav.Link>
                            <Nav.Link href="#pricing">Archives</Nav.Link>
                            <NavDropdown title="News" onMouseEnter={(e) => document.getElementById("nav-dropdown").click()} onMouseLeave={(e) => document.getElementById("nav-dropdown").click()} id="nav-dropdown">
                                <NavDropdown.Item eventKey="4.1">Action</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.2">Another action</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.3">Something else here</NavDropdown.Item>
                                <NavDropdown.Divider />
                                <NavDropdown.Item eventKey="4.4">Separated link</NavDropdown.Item>
                            </NavDropdown>
                            <NavDropdown title="Series" id="nav-dropdown">
                                <NavDropdown.Item eventKey="4.1">Action</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.2">Another action</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.3">Something else here</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.4">Separated link</NavDropdown.Item>
                            </NavDropdown>
                            <Teams></Teams>
                            <NavDropdown title="Videos" id="nav-dropdown">
                                <NavDropdown.Item eventKey="4.1">All Videos</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.2">Categories</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.3">Playlists</NavDropdown.Item>
                            </NavDropdown>
                            <NavDropdown title="Rankings" id="nav-dropdown">
                                <NavDropdown.Item eventKey="4.1">ICC Rankings-Men</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.2">ICC Rankings-Women</NavDropdown.Item>
                                
                            </NavDropdown>
                            <NavDropdown title="More" id="nav-dropdown">
                                <NavDropdown.Item eventKey="4.1">Quiz</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.2">Photos</NavDropdown.Item>
                                <NavDropdown.Item eventKey="4.3">Carrers</NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                        <Form inline>
                            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                            <Button variant="outline-info">Search</Button>
                            <GoogleLogin
                                clientId="939678263258-ohvm8sbripnn4acjevrka1ucmfejorm7.apps.googleusercontent.com"
                                buttonText="Login"
                                onSuccess={responseGoogle}
                                onFailure={responseGoogle}
                                cookiePolicy={'single_host_origin'}
                            />
                            {/* <GoogleLogout
                            clientId="939678263258-ohvm8sbripnn4acjevrka1ucmfejorm7.apps.googleusercontent.com"
                            buttonText="Logout"
                            onLogoutSuccess={logout}
                            onFailure={logout} 
                            disabled={false}
                            ></GoogleLogout> */}
                        </Form>
                    </Navbar>
                </Jumbotron>
            </div>
        );
    }
}


export default NavBar;















