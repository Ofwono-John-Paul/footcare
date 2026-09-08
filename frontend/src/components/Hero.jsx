import React from 'react'

export default function Hero(){
  return (
    <header className="bg-gradient-to-r from-green-400 to-blue-500 text-white py-12">
      <div className="max-w-6xl mx-auto px-4 flex items-center gap-6">
        <div className="flex-1">
          <h1 className="text-4xl font-extrabold">Kimbo Foot Care Ottawa</h1>
          <p className="mt-4">Care for Healthy Steps, At Your Doorstep — Mobile foot care delivered to you.</p>
          <div className="mt-6">
            <a className="inline-block bg-orange-500 hover:bg-orange-600 text-white px-4 py-2 rounded mr-3">Book an Appointment</a>
            <a className="inline-block bg-white text-blue-700 px-4 py-2 rounded">Call 613-413-9064</a>
          </div>
        </div>
        <div className="w-64 h-48 bg-white rounded-lg shadow-md" />
      </div>
    </header>
  )
}
