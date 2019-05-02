$(document).ready( function () {
	 var table = $('#booksTable').DataTable({
			"sAjaxSource": "/booksXCV",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "name" },
				  { "mData": "author" },
				  { "mData": "publisher" },
				  { "mData": "publication_date" },
			]
	 })
});