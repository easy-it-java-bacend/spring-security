package kg.itschool.demo.mapper;

import kg.itschool.demo.model.dto.TransactionDto;
import kg.itschool.demo.model.entity.Transaction;
import org.mapstruct.factory.Mappers;

public interface TransactionMapper extends BaseMapper<Transaction, TransactionDto>{
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
}
