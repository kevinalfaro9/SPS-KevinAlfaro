// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds my favorite foods randomly on the page.
 */
 async function foodGenerator() {
 // responseFromServer will catch the response from the server - in this case
 // it will catch foods string away generated in the FoodServlet class from the doGet function. 
 const responseFromServer = await fetch('/foods');
 // We then cast it to a JSON format so we can process it and utilize it directly on our index HTML page.
 const foods = await responseFromServer.json();
 // We must give it an ID to hook it into our HTML file
 const statsListElement = document.getElementById('food-container');
 // Finally, we call this final line to assign HTML to it from our foods array from our servlet
 // class so we can display the information on the HTML page directly.
 statsListElement.innerHTML = foods[Math.floor(Math.random() * foods.length)];
}
