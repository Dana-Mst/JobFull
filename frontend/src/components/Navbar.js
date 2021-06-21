import { Link } from 'react-router-dom';


const Navbar = () => {
    return ( 
    <nav className="nav ">
        <div className="px-12 mx-auto py-5">
            <div className="flex justify-between">
                <div className="flex items-center ">
                    <div className="logo ">
                        <Link to='/'>.JobFull</Link>
                    </div>
                </div>
             
                    <ul className="flex space-x-6 items-center ">
                        <li> <Link to='/'>Jobs</Link></li>
                        <li><a href="#">Company</a></li>
                        <li> <Link to='/my-account'>My Account</Link></li>
                        <li>&#124;</li>
                        <li> <Link to='/register'>Sign Up</Link></li>
                        <li> <Link to='/login'>Sign In</Link></li>
                    </ul>
             
            
         
            </div>
          

        </div>
    </nav>


     
     );
}
 
export default Navbar;