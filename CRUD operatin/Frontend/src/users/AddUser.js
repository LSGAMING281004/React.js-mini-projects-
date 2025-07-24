import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { Link } from 'react-router-dom'


export default function AddUser() {

    let navigate = useNavigate()

    const [user, setUser]=useState({
        name: "",
        username: "",
        email: ""
    })

    const {name,username, email}=user

    const onInputChange=(e) =>{
        setUser({...user,[e.target.name]:e.target.value})
    }

    const onSubmit=async (e)=>{
        e.preventDefault();
        await axios.post("http://localhost:8080/user",user);
        navigate("/");
    };
  return (
    <div className='container'>
        <div className='row'>
            <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                <form onSubmit={(e)=> onSubmit(e)}>
                <h2 className='text-center m-4'>Register User</h2>
                <div className='mb-3'>
                    <input
                    type={"text"}
                    className='form-control'
                    placeholder='Enter your name'
                    name='name'
                    value={name}
                    required
                    onChange={(e)=>onInputChange(e)}
                    />
                </div>

                 <div className='mb-3'>
                    <input
                    type={"text"}
                    className='form-control'
                    placeholder='Enter your Username'
                    name='username'
                    value={username}
                    required
                     onChange={(e)=>onInputChange(e)}
                    />

                </div>

                 <div className='mb-3'>
                    <input
                    type={"text"}
                    className='form-control'
                    placeholder='Enter your Email address'
                    name='email'
                    value={email}
                    required
                     onChange={(e)=>onInputChange(e)}
                    />
                </div>
                <button type='submit' className='btn btn-outline-primary m-2'>
                    Submit
                </button>
                 <Link className='btn btn-outline-danger m-2' to="/">
                    Cancel
                </Link>
                </form>
            </div>

        </div>

    </div>
  )
}
