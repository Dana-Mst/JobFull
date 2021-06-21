import { Link } from 'react-router-dom';

const Choose = () => {
    return ( 
    <>
    
        <div className="title-choose ">
            <h1>Create An Account</h1>
        </div>
        <div className="wrapper flex justify-evenly">

        <Link to= {"/company-register"} >
                <button className="btn_register rounded-2xl">Company</button> 
            </Link>

           
            <Link to= {"/user-register"}>
                <button className="btn_register rounded-2xl ">Candidate</button>
            </Link>
        
        </div>  
       
             
       

    </>

);
}

export default Choose;