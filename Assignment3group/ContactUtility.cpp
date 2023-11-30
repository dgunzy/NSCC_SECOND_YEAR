#include "Contact.h"
#include "ContactUtility.h"
#include <iostream>


void ContactUtility::addContact(std::vector<Contact*>& contacts) {
    std::cout << "Enter the name of the Contact:";
    std::string userName {};
    getline(std::cin, userName );
    std::cout << "Enter the age of the Contact:";
    int userAge {};
    std::cin.clear();
    std::cin >> userAge;

    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    std::cout << "\n";
    auto* newContact = new Contact(new std::string(userName), userAge);
    contacts.push_back(newContact);
}

void ContactUtility::sortContacts(std::vector<Contact *>& contacts) {
    std::sort(contacts.begin(), contacts.end(), [](Contact* a, Contact* b) {
        return a->m_name->c_str() < b->m_name->c_str();
    });
}

void ContactUtility::printContacts(std::vector<Contact *>& contacts) {
    sortContacts(contacts);
    for(int i = 0; i < contacts.size(); i ++) {
        std::cout <<"Name: "  << (*contacts.at(i)).m_name->c_str() << " Age:" <<  (*contacts.at(i)).m_age <<std::endl;
    }
}
