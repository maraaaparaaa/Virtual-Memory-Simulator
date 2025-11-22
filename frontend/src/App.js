import React from "react";
import MemorySimulator from "./components/MemorySimulator";

function App() {
  return (
    <div 
      className="App" 
      style={{
        background: "linear-gradient(to right, #c1e8ffff, #eec5f3ff)",
        minHeight: "100vh", 
        }}>
      <h1 style={{color: "#d021f3ff"}}>Virtual Memory Simulator</h1>
      <MemorySimulator />
    </div>
  );
}

export default App;
