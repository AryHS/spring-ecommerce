package com.ibm.ecommerce.service.order;

import com.ibm.ecommerce.model.Summary;
import com.ibm.ecommerce.repository.ISummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryServiceImpl implements ISummaryService{
  @Autowired
  private ISummaryRepository summaryRepository;

  @Override
  public Summary save(Summary summary) {
    return summaryRepository.save(summary);
  }
}
