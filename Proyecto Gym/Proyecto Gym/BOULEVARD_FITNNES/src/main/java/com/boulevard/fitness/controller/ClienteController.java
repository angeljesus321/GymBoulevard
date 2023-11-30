package com.boulevard.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boulevard.fitnes.validaciones.ClienteRequest;
import com.boulevard.fitness.entidades.Clase;
import com.boulevard.fitness.entidades.Cliente;
import com.boulevard.fitness.entidades.Documento;
import com.boulevard.fitness.entidades.Membresia;
import com.boulevard.fitness.repository.ClaseRepository;
import com.boulevard.fitness.repository.ClienteReporsitory;
import com.boulevard.fitness.repository.DocumentoRepository;
import com.boulevard.fitness.repository.MembresiaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteReporsitory clienteRepo;
	

	@Autowired
	ClaseRepository claseRepo;

	@Autowired
	DocumentoRepository documentoRepo;
	
	@Autowired
	MembresiaRepository membresiaRepo;
	
	 @GetMapping
	    public List<Cliente> listarClientes() {
	        return clienteRepo.findAll();
	    }

	// REGISTRAR
	 @PostMapping("/registrar")
	 @ResponseStatus(code = HttpStatus.CREATED)
	 public ResponseEntity<Cliente> register(@RequestBody @Valid ClienteRequest clienteRequest) {
	     Cliente cliente = new Cliente();
	     cliente.cod_cli = clienteRequest.cod_cli;
	     cliente.nom_cli = clienteRequest.nom_cli;
	     cliente.ape_cli = clienteRequest.ape_cli;
	     cliente.numdoc_cli = clienteRequest.numdoc_cli;
	     cliente.telf_cli = clienteRequest.telf_cli;
	     cliente.correo_cli = clienteRequest.correo_cli;
	     cliente.fecha_inicio = clienteRequest.fecha_inicio;
	     cliente.fecha_fin = clienteRequest.fecha_fin;

	     // Asigna solo los IDs a la entidad Cliente
	     cliente.tipo_clase = new Clase();
	     cliente.tipo_clase.setCod_clase(clienteRequest.tipo_claseId);

	     cliente.tipo_membresia = new Membresia();
	     cliente.tipo_membresia.setCod_membresia(clienteRequest.tipo_membresiaId);

	     cliente.tipo_documento = new Documento();
	     cliente.tipo_documento.setCod_documento(clienteRequest.tipo_documentoId);

	     Cliente clienteRegistrado = clienteRepo.save(cliente);

	     return new ResponseEntity<>(clienteRegistrado, HttpStatus.CREATED);
	 }
	 
	// OBTENER POR ID
		@GetMapping("/{id}")
		public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable String id) {
			Optional<Cliente> optionalCliente = clienteRepo.findById(id);

			return optionalCliente.map(cliente -> ResponseEntity.ok(cliente))
					.orElseGet(() -> ResponseEntity.notFound().build());
		}
	 
	 //Actualizar
		@PutMapping("/{id}")
		public ResponseEntity<Cliente> actualizarCliente(@PathVariable String id,
		        @RequestBody @Validated ClienteRequest clienteRequest) {

		    return clienteRepo.findById(id).map(cliente -> {
		        cliente.nom_cli = clienteRequest.nom_cli;
		        cliente.ape_cli = clienteRequest.ape_cli;
		        cliente.numdoc_cli = clienteRequest.numdoc_cli;
		        cliente.telf_cli = clienteRequest.telf_cli;
		        cliente.correo_cli = clienteRequest.correo_cli;
		        cliente.fecha_inicio = clienteRequest.fecha_inicio;
		        cliente.fecha_fin = clienteRequest.fecha_fin;

		        // Recupera las instancias reales de Clase, Membresia y Documento
		        Clase clase = claseRepo.findById(clienteRequest.tipo_claseId).orElse(null);
		        Membresia membresia = membresiaRepo.findById(clienteRequest.tipo_membresiaId).orElse(null);
		        Documento documento = documentoRepo.findById(clienteRequest.tipo_documentoId).orElse(null);

		        // Asigna las instancias reales a la entidad Cliente
		        cliente.tipo_clase = clase;
		        cliente.tipo_membresia = membresia;
		        cliente.tipo_documento = documento;

		        return ResponseEntity.ok(cliente);
		    }).orElseGet(() -> ResponseEntity.notFound().build());
		}
		@PutMapping("/actualizar")
        @ResponseBody
        public Cliente actualizarCliente(@RequestBody Cliente cliente) {
            return clienteRepo.save(cliente);
        }
		

		// ELIMINAR
		@DeleteMapping("/eliminar/{id}")
		public void deleteById(@PathVariable String id) {
			clienteRepo.deleteById(id);
		}
	
}
