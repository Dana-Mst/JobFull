import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

class CompanyRegistration extends Component {
  constructor(props) {
    super(props);
    this.state = {
      //no needed.
    };
  }

  onSubmitForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const body = {};
    formData.forEach((value, property) => (body[property] = value));
    //here you can update, remove, add values/properties in the body object this is specially usefull if any custom process must be done to check, encrypt data or wherever you want.
   
    axios({
      method: 'post',
      url: 'http://localhost:8080/api/company/addCompany',
      data: body,
      headers: { 
    'Access-Control-Allow-Origin': '*' },
    })
      .then(function (response) {
        //handle success
        console.log(response);
      })
      .catch(function (response) {
        //handle error
        console.log(response);
      });
    console.table(body);
    // Request goes here.
  };

  render() {
    return (
      <>
        <section className='mt-10'>
          <form
            onSubmit={(e) => this.onSubmitForm(e)}
            className='flex flex-col'
            method='POST'
            action='#'
          >
            <div className='container mx-auto py-8'>
              <div className='w-5/6 lg:w-1/2 mx-auto bg-white rounded shadow'>
                <div className='text-center py-4 px-8 text-black text-xl border-b border-grey-lighter'>
                  Please fill in the form to register your company
                </div>
                <div className='py-4 px-8'>
                  <div className='mb-4'>
                    <label
                      className='block text-grey-darker text-sm font-bold mb-2'
                      for='name'
                    >
                      Company Details
                    </label>
                    <input
                      className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-gray-900'
                      name='name'
                      type='text'
                      defaultValue=''
                      placeholder='Company Name'
                      required
                    />
                  </div>
                  <div className='flex mb-4'>
                    <div className='w-1/2 mr-1'>
                      <input
                        className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-900'
                        name='uniqueRegistrationCode'
                        type='text'
                        defaultValue=''
                        placeholder='Unique Registration Code'
                        required
                      />
                    </div>
                    <div className='w-1/2 ml-1'>
                      <input
                        className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-900'
                        name='tradeRegisterSerialNumber'
                        type='text'
                        defaultValue=''
                        placeholder='Trade Register Serial Number'
                        required
                      />
                    </div>
                  </div>
                  <div className='mb-4'>
                    <label
                      className='block text-grey-darker text-sm font-bold mb-2'
                      for='adress'
                    >
                      Registered Office Address
                    </label>
                    <input
                      className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                      name='adress'
                      type='text'
                      defaultValue=''
                      placeholder='Street and number'
                      required
                    />
                  </div>
                  <div className='flex mb-4'>
                    <div className='w-1/2 mr-1'>
                      <input
                        className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                        name='city'
                        type='text'
                        defaultValue=''
                        placeholder='City'
                        required
                      />
                    </div>
                    <div className='w-1/2 ml-1'>
                      <input
                        className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                        name='country'
                        type='text'
                        defaultValue=''
                        placeholder='Country'
                        required
                      />
                    </div>
                  </div>
                  <div className='mb-4'>
                    <label
                      className='block text-grey-darker text-sm font-bold mb-2'
                      for='email'
                    >
                      Contact Details
                    </label>
                  </div>
                  <div className='flex mb-4'>
                    <div className='w-1/2 mr-1'>
                      <input
                        className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                        name='phoneNumber'
                        type='text'
                        defaultValue=''
                        placeholder='Phone Number'
                        required
                      />
                    </div>
                    <div className='w-1/2 ml-1'>
                      <input
                        className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                        name='email not set for backend'
                        type='email'
                        defaultValue=''
                        placeholder='Email Address'
                        required
                      />
                    </div>
                  </div>
                  <div className='mb-4'>
                    <label
                      className='block text-grey-darker text-sm font-bold mb-2'
                      for='email'
                    >
                      Authentication Data
                    </label>
                    <input
                      className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                      name='email'
                      type='email'
                      defaultValue=''
                      placeholder='Username'
                      required
                    />
                  </div>
                  <div className='mb-4'>
                    <input
                      className='bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                      name='password'
                      type='password'
                      defaultValue=''
                      placeholder='Your secure password'
                      required
                    />
                    <p className='text-grey text-xs mt-1'>
                      At least 6 characters
                    </p>
                  </div>
                  <div className='mb-4'>
                    <label
                      className='text center block text-grey-darker text-sm font-bold mb-2'
                      for='file'
                    >
                      Upload your image
                    </label>
                    <input
                      className='text center bg-gray-200 appearance-none border rounded w-full py-2 px-3 text-grey-darker'
                      type='file'
                      name='file'
                      // onChange={(e) => this.handleFile(e)}
                    />
                    <button
                      className='w-full bg-purple-600 hover:bg-purple-700 text-white font-bold py-2 rounded shadow-lg hover:shadow-xl transition duration-200'
                      type='submit'
                    >
                      Upload Image
                    </button>
                  </div>
                  <button
                    className='w-full bg-purple-600 hover:bg-purple-700 text-white font-bold py-2 rounded shadow-lg hover:shadow-xl transition duration-200'
                    type='submit'
                  >
                    Create Account
                  </button>
                </div>
              </div>
            </div>
          </form>
        </section>
        <div className='max-w-lg mx-auto text-center '>
          <p>
            Already have an account?{' '}
            <Link to={'/login'} className='font-bold hover:underline'>
              Sign in
            </Link>
            .
          </p>
        </div>
      </>
    );
  }
}

export default CompanyRegistration;
