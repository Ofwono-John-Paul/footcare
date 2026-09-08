import React from 'react'
import ServicesList from '../components/ServicesList'

export default function Services(){
  return (
    <div className="max-w-6xl mx-auto p-4">
      <h1 className="text-3xl font-bold my-6">Services</h1>
      <ServicesList />
    </div>
  )
}
