import data from '../assets/companyDescription.json';
import {useState, useEffect} from 'react';
import axios from 'axios';

const DisplayCompanyProfile = (props) => {
    const{ match }= props;
    const{ params } = match;
    const{ companyId }= params;
    const [company, setCompany] = useState([])


    useEffect(()=>{
        const fetchItems = async()=>{
            const response = await axios(`/api/company/${companyId}`)
            const singleCompanyData = response.data;
            // console.log(response.data);
            setCompany(singleCompanyData);
            
        }
        fetchItems()
    },[])

    const item=company;
    console.log(item.logo)
   

    return ( 
        <>
        <div className="container m-auto px-20 singleJob">
            <div className='logo flex items-center'>
                <img className="w-60" src={`.${item.logo}`} alt=""/>
                <div className='title flex justify-center font-bold text-6xl  '>
                <h1>{item.name}</h1>
          
            </div>
         
            </div>
        <div>
            
            <div className="text-gray-800 font-bold flex justify-center text-6xl py-4">
                <h2>About</h2>
            </div>
            <div className='descriprion px-12 justify-center flex text-lg'>
           
                <h3>{item.description}
                </h3>
            </div>
            <div className="text-gray-800 font-bold flex justify-center text-3xl py-4">
                <h2>Contact</h2>
            </div>
            <div className='detail  flex justify-between font-bold m-3 py-1 px-6    
                 rounded-2xl uppercase text-sm text-gray-500' >
       
         
                <span><i className="fas fa-map-marker-alt"></i>{item.adress} </span>
                <a href="tel:+1123-456-7890"><i className="fas fa-phone-square-alt"></i>{item.phoneNumber}</a>
                <a href="mailto:email@example.com"><i className="fas fa-envelope"></i> {item.email}</a>
                <a href="#"><i className="fas fa-at"></i>{item.website}</a>
              
            </div>  
        </div>
     
    

        </div>
           
        </>
     );
}
 
export default DisplayCompanyProfile;