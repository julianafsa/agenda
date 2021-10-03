package br.com.santander.agenda.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.repository.ContatoRepository;
import br.com.santander.agenda.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

    ContatoRepository repository;
    
    @Value("${file.upload.dir}")
    private String dir;
    
    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.repository = contatoRepository;
    }

    @Override
    public Optional<Contato> getContact(Integer id){
        return repository.findById(id);
    }
    
    @Override
    public List<Contato> getAll(){
        return repository.findAll();
    }

    @Override
    public Contato saveContact(Contato contato) {
        return repository.save(contato);
    }

	@Override
	public List<Contato> searchByContato(String nome, String sobrenome, LocalDate dataNascimento, String apelido) {
		return repository.searchByContato(nome, sobrenome, dataNascimento, apelido);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public String updatePhoto(MultipartFile file) {
		
		File uploadFile = new File(dir+file.getOriginalFilename());

		try {
			uploadFile.createNewFile();
			FileOutputStream fso = new FileOutputStream(uploadFile);
			fso.write(file.getBytes());
			fso.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return uploadFile.getAbsolutePath();
		
	}
	
//	// Gerar um nome aleatório para o arquivo
//	private final String randomFileName(String filename) {
//		String extName = filename.substring(filename.lastIndexOf(".") + 1);
//		Random random = new Random();
//		try {
//			byte[] chars = ((Double) (random.nextDouble() * LocalDateTime.now().getNano()))
//					.toString().getBytes();
//			random.nextBytes(chars);
//			byte[] charBytes = Base64.encodeBase64(chars);
//			return new String(charBytes, "UTF-8").replace("/", "0") + "." + extName;
//		} catch (UnsupportedEncodingException e) {
//			throw new StorageException("Falha ao gerar nome do arquivo", e);
//		}
//	}

}
