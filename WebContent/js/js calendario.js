$(document).ready(function() {
    myEvents = [

        {
            name: "New Year",
            date: "Wed Jan 01 2020 00:00:00 GMT-0800 (Pacific Standard Time)",
            type: "holiday",
            everyYear: true
        },

        {
            name: "Valentine's Day",
            date: "Fri Feb 14 2020 00:00:00 GMT-0800 (Pacific Standard Time)",
            type: "holiday",
            everyYear: true
        },

        {
            name: "Birthday",
            date: "February/3/2020",
            type: "birthday"
        }, {
            name: "Author's Birthday",
            date: "February/15/2020",
            type: "birthday",
            everyYear: true
        }, {
            name: "Holiday",
            date: "February/15/2020",
            type: "event"
        },

    ]

    $('#evoCalendar').evoCalendar({
        theme: 'Midnight Blue'
    });

});