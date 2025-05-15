package org.example.expert.domain.todo.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagingCond {

private String weather;

@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
private LocalDateTime toDate;

@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
private LocalDateTime fromDate;
}
