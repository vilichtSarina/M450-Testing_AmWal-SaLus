describe('Counter', () => {
    beforeEach(() => {
      cy.visit('/');
    });
  
    it('contains default students', () => {
    cy.contains('List Students').click();
    cy.contains('Jonas');
    cy.contains('Patrick');
    cy.contains('Yves');
    cy.contains('Peter');
    cy.contains('Ann');
    });

    it('add student', () => {
        cy.contains('Add Students').click();
        cy.get('#name').type('Amanda');
        cy.get('#email').type('amanda@tbz.ch');
        cy.contains('Submit').click();
        });

        it('contains default students and added student', () => {
            cy.contains('List Students').click();
            cy.contains('Jonas');
            cy.contains('Patrick');
            cy.contains('Yves');
            cy.contains('Peter');
            cy.contains('Ann');
            cy.contains('Amanda');
            });   
  });