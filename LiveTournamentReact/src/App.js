import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import NavBar from './components/NavBar';
import VideoCarousel from './components/VideoCarousel';
import MatchesJumbo from './components/MatchesJumbo';
import Lay from './components/Lay';



function App() {
  return (
    <div className="App">
      <NavBar/>
      <MatchesJumbo/>
      <VideoCarousel/>
      <Lay/>
      
      
      
    </div>
  );
}

export default App;
