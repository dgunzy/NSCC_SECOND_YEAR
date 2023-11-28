
const express = require('express');
const app = express();
require('dotenv').config();
const path = require('path');

const PORT = process.env.PORT || 3000;
const fs = require('fs');

const ejs = require('ejs');

app.set('view engine', 'ejs');

app.use(express.static('public'));

app.get('/tempChart', (req, res) => {

  const templatePath = path.join(__dirname, 'public', 'tempChart.ejs');

  const dataFilePath = path.join(__dirname, 'data.json');

  fs.readFile(templatePath, 'utf8', (err, templateData) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error reading the template file');
    } else {
      fs.readFile(dataFilePath, 'utf8', (jsonErr, jsonData) => {
        if (jsonErr) {
          console.error(jsonErr);
          res.status(500).send('Error reading the JSON file');
        } else {
          try {
            const parsedData = JSON.parse(jsonData);
            const renderedHtml = ejs.render(templateData, { data: parsedData });
            res.send(renderedHtml);
          } catch (parseError) {
            console.error(parseError);
            res.status(500).send('Error parsing JSON');
          }
        }
      });
    }
  });
});


app.get('/popChart', (req, res) => {
  const templatePath = path.join(__dirname, 'public', 'popChart.ejs');
  const dataFilePath = path.join(__dirname, 'data.json');

  fs.readFile(templatePath, 'utf8', (err, templateData) => {
    if (err) {
      console.error(err);
      res.status(500).send('Error reading the template file');
    } else {
      fs.readFile(dataFilePath, 'utf8', (jsonErr, jsonData) => {
        if (jsonErr) {
          console.error(jsonErr);
          res.status(500).send('Error reading the JSON file');
        } else {
          try {
            const parsedData = JSON.parse(jsonData);
            const renderedHtml = ejs.render(templateData, { data: parsedData });
            res.send(renderedHtml);
          } catch (parseError) {
            console.error(parseError);
            res.status(500).send('Error parsing JSON');
          }
        }
      });
    }
  });
});

app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});