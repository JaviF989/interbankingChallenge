package org.favilli.interbanking.challenge.api.infrastructure.mapper;

public interface IMapper <I, O>{

    O map(I in);
}
