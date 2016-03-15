package br.com.semear.gestao.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.service.ParticipacaoInstituicaoProjetoService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ParticipacaoInstituicaoProjetoServiceImpl implements ParticipacaoInstituicaoProjetoService{

}
