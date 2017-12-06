var app = require('http').createServer(handler)
var io = require('socket.io')(app);
var fs = require('fs');

app.listen(8180, () => console.log('listening on port ' + 8180));


function handler(req, res) {
    fs.readFile(__dirname + '/index.html',
        function (err, data) {
            if (err) {
                res.writeHead(500);
                return res.end('Error loading index.html');
            }

            res.writeHead(200);
            res.end(data);
        });
}

var connect_num = 0;

io.on('connection', function(socket) {
    var url = socket.request.headers.referer;

    console.log('connected one total:' + connect_num++);

    console.log('地址是：' + socket.request.headers.referer);

    socket.on('disconnect', function() {
        console.log('user disconnected total:' + connect_num--);
        io.emit('user disconnect');
    });
});

// var chat = io
//     .of('/chat')
//     .on('connection', function (socket) {
//         socket.emit('connect', 'chat connect');

//         socket.emit('a message', {
//             that: 'only'
//             , '/chat': 'will get'
//         });
//         chat.emit('a message', {
//             everyone: 'in"'
//             , '/chat': 'will get'
//         });

//         chat.on('chat message', function (msg) {
//             console.log('chat connected ' + msg);
//         });

//         socket.on('say hi',function (msg) {
//             console.log('chat say hi!!!!');
//         });
//     });

// var news = io
//     .of('/news')
//     .on('connection', function (socket) {
//         socket.emit('item', {news: 'item'});

//         news.on('say hi',function (msg) {
//             console.log('chat say hi!!!!');
//         });
//     });