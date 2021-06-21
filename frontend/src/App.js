import {BrowserRouter, Route} from 'react-router-dom';
import DisplayAllJobs from "./components/DisplayAllJobs";
import DisplayCompanyProfile from "./components/DisplayCompanyProfile";
import DisplaySingleJob from './components/DisplaySingleJob';
import Navbar from "./components/Navbar";
import Test from './components/Test'
import Login from './components/Login';
import CustomerAccount from './components/CustomerAccount';
import AddJob from './components/AddJob';
import Choose from './components/Choose';
import CompanyRegistration from './components/CompanyRegistration';
import UserRegistration from './components/UserRegistration';

function App() {
 
  return (
    <BrowserRouter>
      <div className="App">

          <Navbar/>
          {/* <AddJob/> */}

          <Route exact path='/' render={(props)=><DisplayAllJobs{...props}/>}/>
          <Route exact path='/jobs/:companyId/:jobId' render={(props)=><DisplaySingleJob {...props}/>}/>
          <Route exact path='/my-account' render={(props)=><CustomerAccount {...props}/>}/>
          <Route exact path='/company/:companyId' render={(props)=><DisplayCompanyProfile {...props}/>}/> 
          <Route exact path='/login' render={(props)=><Login {...props}/>}/>
          <Route exact path='/register' render={(props)=><Choose {...props}/>}/>
          <Route exact path='/company-register' render={(props)=><CompanyRegistration {...props}/>}/>
          <Route exact path='/user-register' render={(props)=><UserRegistration {...props}/>}/>
      </div>
    </BrowserRouter>
  );
}

export default App;
