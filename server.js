const express = require('express');
const bodyParser = require('body-parser');
const admin = require('firebase-admin');

const app = express();
const port = process.env.PORT || 3000;

app.use(bodyParser.json());

// Konfigurasi Firebase
const serviceAccount = require('./AccountKey.json');
admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
});


  // Definisikan rute untuk login
app.post('/api/login', async (req, res) => {
  const { email, password } = req.body;

  try {
    // Gantilah signInWithEmailAndPassword dengan auth().getUserByEmail
    const userRecord = await admin.auth().getUserByEmail(email);

    // Verifikasi kata sandi atau metode otentikasi lainnya di sini

    res.json({ user: userRecord });
  } catch (error) {
    res.status(401).json({ error: error.message });
  }
});

// Definisikan rute untuk register
app.post('/api/register', async (req, res) => {
  const { email, password } = req.body;

  try {
    const user = await admin.auth().createUser({
      email,
      password,
    });
    res.json({ user });
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
});

  app.get('/', (req, res) => {
    res.send('Selamat datang di server API Firebase.');
  });

// Jalankan server
app.listen(port, () => {
  console.log(`Server berjalan di http://localhost:${port}`);
});

