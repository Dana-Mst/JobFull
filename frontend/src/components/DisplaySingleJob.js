import data from '../assets/data.json';
import {useState, useEffect} from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const DisplaySingleJob = (props)=>{
    const [singleJob, setSingleJob] = useState([]);
    const{ match }= props;
    const{ params } = match;
    const{ companyId, jobId }= params;


    useEffect(()=>{
        const fetchItems = async()=>{
            console.log(companyId, jobId);
            const response = await axios(`/api/jobs/${jobId}/${companyId}`);
            const singleJobData = response.data;
            // console.log(response.data);
            setSingleJob(singleJobData);
            
        }
        fetchItems()
    },[])

    const item = singleJob;
    console.log(item.logo)
  
    const languages = item.languages;

    return ( 
        <>
      
     
        <div className="container m-auto px-20 singleJob">
            <div className='logo flex items-center'>
                <img className="w-60" src={`.${item.logo}`} alt=""/>
                <div className='title flex justify-center font-bold text-6xl  m-auto'>
                <h1>{item.position}</h1>
          
            </div>
            <button className="btn" type="submit"> Apply</button>
            </div>
        <div>
                   <div className="companyDetaile flex justify-between ml-4 py-12  ">
            <Link to={`/company/${item.companyId}`}>
                <p>{item.company} </p>
            </Link>
                <span> jobs opening: {item.openPositions}</span>
            </div>
            <div className='detail  flex justify-between font-bold m-3 py-1 px-6    
                 rounded-2xl uppercase text-sm text-gray-500' >
                <span>Work Location : {item.location}</span>
                <span>Job Type: {item.contract}</span>
                <span>Career Level: {item.level}</span>
                <span>Job Role: {item.role}</span>
                <span>Languages: {languages}</span>
            </div>
            <div className="text-gray-800 font-bold">
                <h2>Job Description</h2>
            </div>
            <div className='descriprion px-12 justify-center flex text-lg'>
           
                <h3>{item.description}
                </h3>
            </div>
        </div>
          <div className='flex justify-center '>
            <button className="btn " type="submit">Apply</button>
          </div>
        </div>
        </>
     );
}
 
export default DisplaySingleJob;