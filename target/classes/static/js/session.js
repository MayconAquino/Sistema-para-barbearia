function usuarioOffline() {
	$.ajax({
		method: "POST",
		url: "/usuario/offline"
	})
}

