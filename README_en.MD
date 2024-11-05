## Project Name
Online UI Automated Inspection Project

## Overview
This project is an online UI automated inspection tool designed to help developers and testers quickly and efficiently detect any abnormalities in the UI interfaces of online web applications. Through automated inspections, potential issues can be identified and resolved promptly, enhancing user experience and product quality.

## demo
- URL: https://check.itest.ren/  @zdx0122
- 
- We welcome developers to provide deployed projects for public access and shared inspection resources.

## Features
- Automated Inspection: Scheduled or real-time inspection tasks without manual intervention.
- Multiple Inspection Rules: Supports title comparison and visual regression testing of pages.
- Real-time Feedback: Inspection results are displayed in real-time, including screenshots of issues, problem descriptions, and localization information.
- Cross-platform Support: Compatible with mainstream browsers and operating systems to meet diverse environmental needs.
## Usage Instructions
### Installation and Deployment
- Clone this project to your local machine.。
- For Docker deployment, refer to doc/docker 部署手册.md
- Local Startup
  - Basic Environment：nodejs、jdk1.8、maven
  - mysql: Use the table creation statements in db/ddl.sql
  - online-server (Spring Boot project): After installing dependencies, start with one click. Access URL: http://127.0.0.1:9091/
  - online-client (Vue project): Access URL: http://127.0.0.1:5173/
  ``` 
  npm install    // to install dependencies
  npm run dev    // to start
  ```
### Inspection Case Entry
- Click on the "H5 用例" menu on the left.
- Click the "新增" button
- Fill in case information, including the H5 page title, inspection URL, business line, and DingTalk/WeChat Work/Feishu group robot key.
- Submit

### Inspection Rules
- Inspection tasks are executed every 5 minutes.
- Inspection Content
  - Page availability check (white screen).
  - Page pixel comparison (similarity < 60%).
  - Case execution duration statistics.


### Inspection Results
- Inspection results are displayed in real-time on the designated page.
- The "巡检记录" menu allows you to view today's inspection records.
- The "数据看板" menu provides insights into case execution data over a recent period.

### Abnormal Case Alerts
- Alerts are sent for incorrect page title comparisons (requires group robot key configuration).
- Alerts are sent for page pixel comparison similarities below 60% (requires group robot key configuration).
## Technology Stack
- Programming Language: Java.
- Framework: Spring Boot.
- Automated Testing Tool: Playwright + TestNG.
- Database: MySQL (5.7).
- Frontend Technology: Vue 3.
## Contribution Guidelines
We welcome contributions in the form of code, documentation, and suggestions from all developers. Before submitting your contributions, please follow these steps:

Fork this project to your GitHub repository.
Create and switch to a new development branch in your repository.
Make code modifications, add documentation, or submit other contributions.
Commit your changes and push them to your GitHub repository.
Initiate a Pull Request to the main branch of this project.
We will review and test the submitted Pull Request. Once approved, it will be merged into the main branch and a new version will be released.

### Contribution of Inspection Resources
Due to limited machine resources, the demo site can only use a few URLs for public experience. We welcome developers to provide deployed projects for public access and shared inspection resources.

## Contact Information
For any questions, suggestions, or needs, please contact us through the following channels:

- GitHub Repository Comment
- Email：zdx0122@gmail.com

## Star History

[![Star History Chart](https://api.star-history.com/svg?repos=TheCoolQATeam/online-inspection-tracker&type=Date)](https://star-history.com/#TheCoolQATeam/online-inspection-tracker&Date)

## License
This project is licensed under the Apache License. Please adhere to the relevant license agreement when using this project.