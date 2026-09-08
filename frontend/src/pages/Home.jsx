import React from 'react'
import Hero from '../components/Hero'
import ServicesList from '../components/ServicesList'

export default function Home(){
  return (
    <div>
      <Hero />
      <main className="max-w-6xl mx-auto p-4">
        <section className="my-8">
          <h2 className="text-2xl font-bold mb-4">Our Services</h2>
          <ServicesList />
        </section>
      </main>
    </div>
  )
}
