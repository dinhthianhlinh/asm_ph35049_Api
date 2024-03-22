const express = require('express');
const app = express();
const port = 3000;
const bodyParser = require("body-parser");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
});

const COMMON = require('./COMMON');

const uri = COMMON.uri;

const mongoose = require('mongoose');

const phoneModel = require('./phoneModel');

const apiMobile = require('./api');
app.use('/api', apiMobile);

app.get('/', async (req, res) => {
    await mongoose.connect(uri);

    let phones = await phoneModel.find();

    console.log(phones);

    res.send(phones);

})

app.post('/add_phone', async (req, res) => {
    await mongoose.connect(uri);

    // let car = {
    //     ten: 'xe 3',
    //     namSX: 2024,
    //     hang: 'Mitsubishi',
    //     gia: 7500
    // }

    let phone = req.body;

    console.log(phone)

    let kq = await phoneModel.create(phone);
    console.log(kq);

    let phones = await phoneModel.find();

    res.send(phones);

})

// app.get('/xoa/:id', async (req, res) => {
//     await mongoose.connect(uri);

//     let id = req.params.id;
//     console.log(id);

//     // xu ly loi khi id khong dung
//     await phoneModel.deleteOne({_id: id});

//     res.redirect('../')
// }) 

// app.get('/update/:ten', async (req, res) => {
//     await mongoose.connect(uri);

//     console.log('Ket noi DB thanh cong');

//     let tenXe = req.params.ten;
//     console.log(tenXe);

//     let tenXeMoi = tenXe + ' Phien ban moi 2024';

//     await carModel.updateOne({ten: tenXe}, {ten: tenXeMoi});

//     let xehois = await carModel.find({});

//     res.send(xehois);
// })