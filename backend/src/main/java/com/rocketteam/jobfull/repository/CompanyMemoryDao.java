package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Customer;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.model.users.CurriculumVitae;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Instant;
import java.util.*;

@Repository("CompanyMemoryDao")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyMemoryDao implements CompanyDao {
    private List<Company> companies = createCompanyList();
    private List<Customer> applicants = new ArrayList<>();


    @Override
    public Company addCompany(Company company) {
        company.setId(UUID.randomUUID());
        company.setApplicants(new ArrayList<>());
        company.setJobs(new ArrayList<>());
        companies.add(company);
        return company;
    }

    @Override
    public boolean deleteCompany(UUID id) {
        return companies.removeIf(company -> company.getId().equals(id));
    }

    @Override
    public Optional<Company> getCompanyById(UUID id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean updateCompanyById(UUID id, Company companyToUpdate) {
        return getCompanyById(id)
                .map(company -> {
                    int indexOfJobToUpdate = companies.indexOf(company);
                    if (indexOfJobToUpdate >= 0) {
                        companies.set(indexOfJobToUpdate, companyToUpdate);
                        return true;
                    }
                    return false;
                }).orElse(false);
    }

    @Override
    public List<Job> getAllJobsFromCompanyList() {
        List<Job> jobs = new ArrayList<>();
        for (Company company : companies) {
            jobs.addAll(company.getJobs());
        }
        return jobs;
    }


    public List<Job> getJobsListByCompanyId(UUID id) {
        List<Job> jobsForCompany = new ArrayList<>();
        for (Company company : companies) {
            if (company.getId().equals(id)) {
                jobsForCompany = company.getJobs();
            }
        }
        return jobsForCompany;
    }

    @Override
    public Job getJobForCompanyById(UUID companyId, UUID jobId) {
        List<Job> companyJobs = getJobsListByCompanyId(companyId);
        Job jobByCompanyAndId = null;
        for (Job job : companyJobs) {
            if (job.getId().equals(jobId)) {
                jobByCompanyAndId = job;
            }
        }
        return jobByCompanyAndId;
    }


    public List<Company> getAllCompanies() {
        return companies;
    }

    public List<Company> createCompanyList() {

        List<Job> photosnapJobs = createPhotosnapJobs();
        List<Job> manageJobs = createManageJobs();
        List<Job> accountJobs = createAccountJobs();
        List<Job> myHomeJobs = createMyHomeJobs();
        List<Job> loopStudiosJobs = createLoopStudiosJobs();

        applicants = createApplicantsList();

        List<Company> companies = new ArrayList<>();
        companies.add(new Company(UUID.fromString("3b4c3d7c-d8e2-46ae-9c33-a1c56fec08fe"),
                        "Photosnap",
                        "The street",
                        "New York",
                        "173945034",
                        "www.photosnap.com",
                        "photosnap@email.com",
                        "Hell of a company,Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "./images/photosnap.svg",
                        "CUI",
                        "J/40/23343",
                        photosnapJobs,
                        applicants
                )
        );

        companies.add(new Company(UUID.fromString("ed6867ea-e073-4a56-a60d-d2429289b85d"),
                        "Manage",
                        "Streets of Tarkov",
                        "Tarkov",
                        "173923434",
                        "www.manage.com",
                        "manage@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "./images/photosnap.svg",
                        "CUI",
                        "J/40/23343/1998",
                        manageJobs,
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.fromString("bc1f0277-ea65-4b11-8e62-474ac12fa2c2"),
                        "Account",
                        "One street",
                        "York",
                        "173999034",
                        "www.account.com",
                        "account@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",

                        "./images/account.svg",
                        "CUI",
                        "J/40/23345/1990",
                        accountJobs,
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.fromString("a36a6060-a63c-4c28-8604-c1bec614bebd"),
                        "MyHome",
                        "The home street",
                        "Bucharest",
                        "173098034",
                        "www.Myhome.com",
                        "myhome@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",

                        "./images/myhome.svg",
                        "CUI",
                        "J/40/23343",
                        myHomeJobs,
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.fromString("19ecda0d-8184-405c-8e78-3061487be89b"),
                        "Loop Studios",
                        "Loop street",
                        "Amsterdam",
                        "173905634",
                        "www.loop-studio.com",
                        "loop-studio@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",

                        "./images/loop-studios.svg",
                        "CUI",
                        "J/40/23343",
                        loopStudiosJobs,
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.randomUUID(),
                        "FaceIt",
                        "The face street",
                        "Oakland",
                        "173000034",
                        "www.face-it.com",
                        "faceit@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",

                        "./images/manage.svg",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.randomUUID(),
                        "Shortly",
                        "The short street",
                        "Short City",
                        "173988734",
                        "www.shortly.com",
                        "shortly@email.com",
                        "A short company",
                        "./images/manage.svg",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.randomUUID(),
                        "Insure",
                        "Insurance street",
                        "Glasgow",
                        "173945111",
                        "www.insure.com",
                        "insure@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",

                        "./images/manage.svg",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.randomUUID(),
                        "Eyecam Co.",
                        "Some street",
                        "California",
                        "177945034",
                        "www.eyecam.com",
                        "eyecam@email.com",
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "./images/manage.svg",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        companies.add(new Company(UUID.randomUUID(),
                        "The Air Filter Job",
                        "Mountain street",
                        "Zurich",
                        "173999034",
                        "www.air-filter-job.com",
                        "air-filter@email.com",

                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",

                        "./images/manage.svg",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        return companies;
    }

    private List<Job> createPhotosnapJobs() {
        List<Job> jobs = new ArrayList<>();

        jobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/photosnap.svg",
                        true,
                        false,
                        "Senior Frontend Developer",
                        "Frontend",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("HTML", "CSS", "JavaScript")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Photosnap",
                        UUID.fromString("3b4c3d7c-d8e2-46ae-9c33-a1c56fec08fe")
                )
        );
        jobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/photosnap.svg",
                        true,
                        true,
                        "Junior Backend Developer",
                        "Backend",
                        "Junior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("PostgresSQL", "Python", "Java")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Photosnap",
                        UUID.fromString("3b4c3d7c-d8e2-46ae-9c33-a1c56fec08fe")
                )
        );

        return jobs;
    }

    private List<Job> createManageJobs() {
        List<Job> manageJobs = new ArrayList<>();

        manageJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/manage.svg",
                        true,
                        true,
                        "Senior Frontend Developer",
                        "Frontend",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("React", "CSS", "JavaScript")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Manage",
                        UUID.fromString("ed6867ea-e073-4a56-a60d-d2429289b85d")
                )
        );
        manageJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/manage.svg",
                        true,
                        true,
                        "Junior Backend Developer",
                        "Backend",
                        "Junior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("PostgresSQL", "Python", "Java")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Manage",
                        UUID.fromString("ed6867ea-e073-4a56-a60d-d2429289b85d")
                )
        );
        manageJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/manage.svg",
                        true,
                        true,
                        "Junior Backend Developer",
                        "Backend",
                        "Junior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("PostgresSQL", "Python", "Java")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Manage",
                        UUID.fromString("ed6867ea-e073-4a56-a60d-d2429289b85d")
                )
        );

        return manageJobs;
    }

    private List<Job> createAccountJobs() {
        List<Job> accountJobs = new ArrayList<>();

        accountJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/account.svg",
                        true,
                        false,
                        "Senior Frontend Developer",
                        "Frontend",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "Europe", new ArrayList<>(List.of("React", "CSS", "JavaScript")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Account",
                        UUID.fromString("bc1f0277-ea65-4b11-8e62-474ac12fa2c2")
                )
        );
        accountJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/account.svg",
                        true,
                        true,
                        "Full Stack Developer",
                        "Full Stack",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "Europe", new ArrayList<>(List.of("PostgresSQL", "Angular", "Java")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Account",
                        UUID.fromString("bc1f0277-ea65-4b11-8e62-474ac12fa2c2")
                )
        );
        accountJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/account.svg",
                        true,
                        true,
                        "Junior Backend Developer",
                        "Junior",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "Europe", new ArrayList<>(List.of("PostgresSQL", "Angular", "Java")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Account",
                        UUID.fromString("bc1f0277-ea65-4b11-8e62-474ac12fa2c2")
                )
        );

        return accountJobs;
    }

    private List<Job> createMyHomeJobs() {
        List<Job> myHomeJobs = new ArrayList<>();

        myHomeJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/myhome.svg",
                        true,
                        false,
                        "Senior Frontend Developer",
                        "Frontend",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("React", "CSS", "JavaScript")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "MyHome",
                        UUID.fromString("a36a6060-a63c-4c28-8604-c1bec614bebd")
                )
        );


        return myHomeJobs;
    }

    private List<Job> createLoopStudiosJobs() {
        List<Job> myHomeJobs = new ArrayList<>();

        myHomeJobs.add(new Job(UUID.randomUUID(),
                        2,
                        "./images/loop-studios.svg",
                        true,
                        false,
                        "Senior Frontend Developer",
                        "Frontend",
                        "Senior",
                        new Date(),
                        "Full Time",
                        "USA Only", new ArrayList<>(List.of("React", "CSS", "JavaScript")),
                        new ArrayList<>(),
                        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
                        "Loop Studios",
                        UUID.fromString("19ecda0d-8184-405c-8e78-3061487be89b")
                )
        );


        return myHomeJobs;
    }

    private List<Customer> createApplicantsList() {
        List<Customer> applicants = new ArrayList<>();
        applicants.add(new Customer(UUID.randomUUID(),
                        new CurriculumVitae(),
                        "Yusef",
                        "Maximilianus",
                        "1724059385",
                        "Yusef@email.com",
                        Date.from(Instant.now())
                )
        );
        return applicants;
    }

}

