import React, {useEffect,useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import {Container ,Paper,Button} from '@material-ui/core';
import { type } from '@testing-library/user-event/dist/type';
// import React from 'react';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },

  },
}));

export default function Student() {
    const paperStyle={padding:'50px 20px',width:600,margin:"20px auto"}
    const classes=useStyles();
    // const formTopic={textAlign: 'center'}
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[tel,setTel]=useState('')
    const[nic,setNic]=useState('')
    const[students,setStudents]=useState([])

    const handleClick=(e)=>{
        e.preventDefault()
        const student={name,address,tel,nic}
        console.log(student)
        fetch("http://localhost:8080/student/add",{
          method:"post",
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify(student)
    }).then(()=>{
        console.log("new student added!!!")
        alert("new student added seccessfully!!!")
    })
}
  
    useEffect(()=>{
        fetch("http://localhost:8080/student/get-All-student")
        .then(res=>res.json())
        .then((result)=>{
          setStudents(result);
        }
      )
      },[])

  return (
    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{fontFamily:"cursive",textAlign:"center",color:"blue"}}>Add Student</h1>
            <form className={classes.root} noValidate autoComplete="off">
            
            <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
            value={name}
            onChange={(e)=>setName(e.target.value)}
            />

            <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth
            value={address}
            onChange={(e)=>setAddress(e.target.value)}
            />
            <TextField id="outlined-basic" label="telephone" variant="outlined" fullWidth
            value={tel}
            onChange={(e)=>setTel(e.target.value)}
            />
            <TextField id="outlined-basic" label="nic" variant="outlined" fullWidth
            value={nic}
            onChange={(e)=>setNic(e.target.value)}
            />
            <Button variant="contained" color="secondary" onClick={handleClick}>Submit</Button>

            </form>
          
        </Paper>
        <h1 style={{fontFamily:"cursive",textAlign:"center",color:"blue"}}>Students</h1>
        <Paper elevation={3} style={paperStyle}>

{students.map(student=>(
  <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
   Id:{student.sid}<br/>
   Name:{student.name}<br/>
   Address:{student.address}<br/>
   Tel:{student.tel}<br/>
   Nic:{student.nic}
   <br/><br/>
<Button variant="contained" color="primary" style={{marginLeft:"2px"}}>update</Button>
<Button variant="contained" color="primary" style={{marginLeft:"2px"}}>delete</Button> 

  </Paper>
))
}


</Paper>

        
    </Container>
 


  );
}