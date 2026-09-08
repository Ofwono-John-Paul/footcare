import React, {useEffect, useState} from 'react'
import axios from 'axios'

export default function ServicesList(){
  const [services, setServices] = useState([])

  useEffect(()=>{
    axios.get('/api/services').then(r=>setServices(r.data)).catch(()=>{
      // fallback demo data
      setServices([
        {id:1,title:'Routine Foot Care', description:'General foot care.'},
        {id:2,title:'Nail Trimming & Care', description:'Safe and professional nail care.'},
        {id:3,title:'Corn & Callus Care', description:'Removal and treatment of hard skin.'},
        {id:4,title:'Diabetic Foot Care', description:'Specialized care for diabetic clients.'},
        {id:5,title:'Foot Assessments', description:'Basic foot health checks.'},
        {id:6,title:'Other Services', description:'Personalized care.'}
      ])
    })
  },[])

  return (
    <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
      {services.map(s=> (
        <div key={s.id} className="border rounded p-4 shadow-sm">
          <h3 className="font-bold text-lg">{s.title}</h3>
          <p className="text-sm mt-2">{s.description}</p>
        </div>
      ))}
    </div>
  )
}
