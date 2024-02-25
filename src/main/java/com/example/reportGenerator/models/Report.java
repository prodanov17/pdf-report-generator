package com.example.reportGenerator.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;

public class Report<T> {
    private String reportNumber;
    private String name;
    private List<T> content;
    private LocalDate date;
    @JsonIgnore
    private byte[] reportBytes;

    public Report(String reportNumber, String name, List<T> content, LocalDate date) {
        this.content = content;
        this.name = name;
        this.reportNumber = reportNumber;
        this.date = date;
    }

    public byte[] getReportBytes() {
        return reportBytes;
    }

    public void setReportBytes(byte[] reportBytes) {
        this.reportBytes = reportBytes;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReportNumber() {
		return reportNumber;
	}

	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
