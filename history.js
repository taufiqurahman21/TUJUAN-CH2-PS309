const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql2');

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Konfigurasi database
const db = mysql.createConnection({
  host: '34.101.117.197', // Sesuaikan dengan konfigurasi database Anda
  user: 'root',
  password: 'Tujuan',
  database: 'response_data',
});

// Cek koneksi ke database
db.connect((err) => {
  if (err) {
    console.error('Koneksi ke database gagal: ', err);
  } else {
    console.log('Terhubung ke database');
  }
});

// Endpoint untuk menyimpan data ke database
app.post('/api/input-data', (req, res) => {
  const { result } = req.body;

  if (!result) {
    return res.status(400).json({ error: 'Field "result" tidak boleh kosong' });
  }

  const query = 'INSERT INTO hasil_data (result) VALUES (?)';
  db.query(query, [result], (err, result) => {
    if (err) {
      console.error('Error saat menyimpan data ke database: ', err);
      return res.status(500).json({ error: 'Internal Server Error' });
    }
    res.status(201).json({ message: 'Data berhasil disimpan' });
  });
});

// Endpoint untuk mengambil data dari database
app.get('/api/get-data', (req, res) => {
  const query = 'SELECT * FROM hasil_data ORDER BY timestamp DESC';

  db.query(query, (err, results) => {
    if (err) {
      console.error('Error saat mengambil data dari database: ', err);
      return res.status(500).json({ error: 'Internal Server Error' });
    }
    res.status(200).json(results);
  });
});

// Jalankan server
app.listen(PORT, () => {
  console.log(`Server berjalan di http://localhost:${PORT}`);
});
