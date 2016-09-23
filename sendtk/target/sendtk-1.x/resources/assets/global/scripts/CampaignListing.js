	
$(function () {

    function fnFormatDetails(oTable, nTr) {
        var aData = oTable.fnGetData(nTr);
        var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
        sOut += '<tr><td><strong>Settings</strong></td>	<td></td></tr>';
        sOut += '<tr><td>Message per IP :</td><td class="number c-blue">'+aData[10]+'</td></tr>';
        sOut += '<tr><td>Fraction    	:</td><td class="number c-blue">'+aData[14]+'</td></tr>';
        sOut += '<tr><td>Count / xDelay :</td><td class="number c-blue">'+aData[13]+'/'+aData[12]+'</td></tr>';
        sOut += '<tr><td>Seed        	:</td><td class="number c-blue">'+aData[11]+'</td></tr>';
        sOut += '<tr><td>Sent to     	:</td><td class="number c-blue">'+aData[15]+' account</td></tr>';
        sOut += '</table>';
        return sOut;
    }

    /*  Insert a 'details' column to the table  */
    var nCloneTh = document.createElement('th');
    var nCloneTd = document.createElement('td');
    nCloneTd.innerHTML = '<i class="fa fa-plus-square-o"></i>';
    nCloneTd.className = "center";

    $('#CampaignListing thead tr').each(function () {
        this.insertBefore(nCloneTh, this.childNodes[0]);
    });

    $('#CampaignListing tbody tr').each(function () {
        this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
    });

    /*  Initialse DataTables, with no sorting on the 'details' column  */
    var oTable = $('#CampaignListing').dataTable({
        "aoColumnDefs": [{
            "bSortable": false,
            "aTargets": [0]
        }],
        "aaSorting": [
            [1, 'asc']
        ]
    });

    /*  Add event listener for opening and closing details  */
    $(document).on('click', '#CampaignListing tbody td i', function () {
        var nTr = $(this).parents('tr')[0];
        if (oTable.fnIsOpen(nTr)) {
            /* This row is already open - close it */
            $(this).removeClass().addClass('fa fa-plus-square-o');
            oTable.fnClose(nTr);
        } else {
            /* Open this row */
            $(this).removeClass().addClass('fa fa-minus-square-o');
            oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
        }
    });

});