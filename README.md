# PDF Report Generation API

Generate professional PDF reports with ease using this hobby project, a simple and flexible PDF report generation API.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Software Design Principles](#software-design-principles)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The PDF Report Generation API is a hobby project designed to simplify the process of creating PDF reports dynamically. Whether you need to generate invoices, statements, or custom reports, this API provides a straightforward solution.

## Features

- Dynamic PDF report generation
- Customizable templates
- Support for adding tables, images, and text
- Easily integrate with existing applications

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- [Maven](https://maven.apache.org/) for building the project

### Installation

1. Clone the repository: `git clone https://github.com/yourusername/pdf-report-generation-api.git`
2. Navigate to the project directory: `cd pdf-report-generation-api`
3. Build the project: `mvn clean install`

### Usage
```java
    List<Products> products = List.of(
            new Products("Product 1", 10, 100.0),
            new Products("Product 2", 20, 200.0),
            new Products("Product 3", 30, 300.0)
    );
    try {
        ReportGenerator<Products> reportGenerator = new PDFReportGenerator<>(new PDFOrderInvoice<Products>(products), "report");
        reportGenerator.generateReport();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
```

### Software Design Principles
This project follows the SOLID principles, emphasizing flexibility, maintainability, and ease of use. The design encourages the separation of concerns, making it easy to extend and customize for specific use cases.

Note: This project is a hobby project, created for personal learning and enjoyment. It is not intended for production use. Contributions and feedback are welcome, but there is no guarantee of active maintenance. Use at your own risk.
