const express = require('express');

const router = express.Router();

module.exports = router;

router.get('/', (req, res) => {
    res.send ('vao api mobile');
})

const mongoose = require('mongoose');

const phoneModel = require('./phoneModel');

const COMMON = require('./COMMON');

router.get('/list', async (req, res) => {
    await mongoose.connect(COMMON.uri);

    let phones = await phoneModel.find();

    console.log(phones);

    res.send(phones);
})