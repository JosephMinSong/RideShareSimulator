<h1 align="center">RideShare Application Simulator</h1>

<h2 align="left">Overview</h2>
<p>This project aims to be a simulation tool designed to model and analyze ride-sharing operations over a specified period. The simulator generates data based on user-defined parameters, providing insights into rider wait times, driver availability, and service efficient under varying conditions. The output data is structured in a CSV format to allow for further analysis and data visualization, helping to optimize ride-share services.</p>

<h2 align="left">Key Features</h2>
<ul>
  <li>
    <p>Configurable Simulation Parameters:</p>
    <ul>
      <li>
        <p><b>Number of riders: </b> The user is able to define the total number of simulated riders or users requesting a ride</p>
      </li>
      <li>
        <p><b>Number of drivers: </b> The user is able to define the total number of drivers able to pick up passengers during the simulated time</p>
      </li>
      <li>
        <p><b>Simulation time/hours: </b> The user is able to set the times for which the simulation runs</p>
      </li>
    </ul>
  </li>
  <li>
    <p>Synthetic Data Generation:</p>
    <ul>
      <li>
        The simulator generates as many rides as the user requests during input, creating a realistic ride requests that a ride share application could receive
      </li>
      <li>
        Each ride request includes a timestamp for when the ride was requested, when the rider was picked up, and how long the rider had been waiting to be picked up
      </li>
    </ul>
  </li>
  <li>
    <p>Priority Status Assignments:</p>
    <p>Each ride is assigned a random priority status based on pre-defined criteria</p>
    <ul>
      <li>
        <b>Express Pick-Up: </b> High-priority pick-up rides with the goal of minimizing wait time
      </li>
      <li>
        <b>Standard Pick-up: </b> Regular rides with no special requirements
      </li>
      <li>
        <b>Wait-and-Save Pick-Up: </b> Lower priority rides that may affect wait times 
      </li>
      <li>
        <b>Environmental Pick-Up: </b> Low priority rides with extended wait times in case there are other riders in the area who are requesting pick-up
      </li>
    </ul>
  </li>
<li>
    <p>Detailed Output and Analysis:</p>
    <p>The simulation outputs an extensive CSV file containing the following data points:</p>
    <ul>
      <li>
        <b>User Request Time: </b> The time when the rider had requested a ride
      </li>
      <li>
        <b>User Pick-Up Time: </b> The time when the rider was picked up by the driver
      </li>
      <li>
        <b>Wait Time: </b> The duration the rider waited between the request and the pick-up
      </li>
      <li>
        <b>Priority Status: </b> The assigned priority the user had chosen for their ride
      </li>
    </ul>
  </li>
</ul>
